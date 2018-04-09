#!/usr/bin/python


import json
import sys
import requests

post_address = 'http://localhost:8080/addEmployee'
post_tests = [
    #{
    #    'name': Test name
    #    'input': Data to be posted
    #    'expect': Expected HTTP result code
    #},
    {
        'name': 'POST 1',
        'data': '{ "FirstName":"Bob", "LastName":"Smith", "Title":"Junior Developer", "Department":"IT", "StartDate":"12/01/2012" }',
        'expect': 200
    },
    {
        'name': 'POST 2',
        'data': '{ "FirstName":"Al", "LastName":"Smith", "Title":"Network Engineer", "Department":"IT", "StartDate":"12/02/2012" }',
        'expect': 200
    },
    {
        'name': 'POST 3',
        'data': '{ "FirstName":"Jack", "LastName":"Smith", "Title":"Comptroller", "Department":"Accounting", "StartDate":"12/03/2012" }',
        'expect': 200
    },
    {
        'name': 'Bad department name',
        'data': '{ "FirstName":"Bob", "LastName":"Smith", "Title":"Junior Developer", "Department":"Technology", "StartDate":"12/01/2012" }',
        'expect': 400
    },
    {
        'name': 'Bad title',
        'data': '{ "FirstName":"Bob", "LastName":"Smith", "Title":"Junior Devvveloper", "Department":"IT", "StartDate":"12/01/2012" }',
        'expect': 400
    },
    {
        'name': 'Test bad date format',
        'data': '{ "FirstName":"Bob", "LastName":"Smith", "Title":"Junior Developer", "Department":"IT", "StartDate":"12/01/20a2" }',
        'expect': 400
    },
    {
        'name': 'Test extra fields',
        'data': '{ "FirstName":"Bob", "LastName":"Smith", "Title":"Junior Developer", "Department":"IT", "StartDate":"12/01/2012" }',
        'expect': 200
    },
    {
        'name': 'Test bad JSON 1',
        'data': '{ "FirstName":, "LastName":"Smith", "Title":"Junior Developer", "Department":"IT", "StartDate":"12/01/2012" }',
        'expect': 400
    },
    {
        'name': 'Test bad JSON 2',
        'data': '[ { "FirstName":"Bob", "LastName":"Smith", "Title":"Junior Developer", "Department":"IT", "StartDate":"12/01/2012" } ]',
        'expect': 400
    },
]

def run_post_tests():
    for test in post_tests:
        print "Running post test: " + test['name']
        request = requests.post(post_address, data=test['data'], headers={'Content-Type': 'application/json'})
        if request.status_code == test['expect']:
            print '  Succcess!'
        else:
            print '  Failure; expected ' + str(test['expect']) + ', got ' + str(request.status_code)





get_tests = [
    #{
    #    'name': Test name
    #    'department': Department to retrieve
    #    'expect': Expected HTTP result code
    #    'output': Expected output; will be normalized and formatted below
    #},
    {
        'name': 'Invalid department',
        'department': 'foo',
        'expect': 404,
        'output': ''
    },
    {
        'name': 'Bad URL format',
        'department': 'Accounting/Finance',
        'expect': 404,
        'output': ''
    },
    {
        'name': 'Department 1 results',
        'department': 'Accounting',
        'expect': 200,
        'output': '''[
{ "Id": 1, "FirstName":"Bob", "LastName":"Smith", "Title":"Junior Developer", "Department":"IT", "StartDate":"12/01/2012"},
{ "Id": 2, "FirstName":"Al", "LastName":"Smith", "Title":"Network Engineer", "Department":"IT", "StartDate":"12/02/2012"}
]'''
    },
    {
        'name': 'Department 2 results',
        'department': 'IT',
        'expect': 200,
        'output': '[{ "Id":1, "FirstName":"Jack", "LastName":"Smith", "Title":"Comptroller", "Department":"Accounting", "StartDate":"12/03/2012"}]'
    },
    {
        'name': 'Empty department',
        'department': 'IT',
        'expect': 200,
        'output': '[]'
    },
]

# fields to use to order output, and to compare between expected / actual
# assumes that records will have IDs that are ascending in the order they are created
output_sort_field = 'Id'
comparison_fields = [ 'FirstName', 'LastName', 'Title', 'Department', 'StartDate' ]


def run_get_tests():
    pass


# parses input JSONs string and returns them line by line, sorted by key
def main():
    run_post_tests()
    
    #jsonObject = json.loads(data)
    #print json.dumps(jsonObject, sort_keys=True, separators=(',', ':'))
    
if __name__ == "__main__": 
    main()
    
    
    
    
    
    
    
    
    
    
    