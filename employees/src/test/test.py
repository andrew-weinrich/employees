#!/usr/bin/python


import json
import sys
import requests
from operator import itemgetter

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
        'name': 'Test extra fields',
        'data': '{ "extra":"value", "FirstName":"Phil", "LastName":"Davies", "Title":"Junior Developer", "Department":"IT", "StartDate":"12/04/2012" }',
        'expect': 400
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
        'name': 'IT department results',
        'department': 'IT',
        'expect': 200,
        'output': '''[
{ "Id": 1, "FirstName":"Bob", "LastName":"Smith", "Title":"Junior Developer", "Department":"IT", "StartDate":"12/01/2012"},
{ "Id": 2, "FirstName":"Al", "LastName":"Smith", "Title":"Network Engineer", "Department":"IT", "StartDate":"12/02/2012"}
]'''
    },
    {
        'name': 'Accounting department results',
        'department': 'Accounting',
        'expect': 200,
        'output': '[{ "Id":1, "FirstName":"Jack", "LastName":"Smith", "Title":"Comptroller", "Department":"Accounting", "StartDate":"12/03/2012"}]'
    },
    {
        'name': 'Empty department',
        'department': 'HR',
        'expect': 200,
        'output': '[]'
    },
]

get_address = 'http://localhost:8080/getEmployeesInDepartment/'

# fields to use to order output, and to compare between expected / actual
# assumes that records will have IDs that are ascending in the order they are created
sort_field = 'Id'
comparison_fields = [ 'FirstName', 'LastName', 'Title', 'Department', 'StartDate' ]
# we intentionally ignore any extra data that might be returned

def run_get_tests():
    for test in get_tests:
        print "Running get test: " + test['name']
        try:
            request = requests.get(get_address + test['department'])
        
            if request.status_code != test['expect']:
                raise Exception('expected ' + str(test['expect']) + ', got ' + str(request.status_code))
            
            if test['expect'] == 200:
                # parse both expected and actual output
                expectedJsonObject = json.loads(test['output'])
                actualJsonObject = request.json()
        
                # sort records by the sort field
                sortedExpectedJsonObject = sorted(expectedJsonObject, key=itemgetter(sort_field))
                sortedActualJsonObject   = sorted(actualJsonObject, key=itemgetter(sort_field))
            
                expectedRecordCount = len(sortedExpectedJsonObject)
                actualRecordCount = len(sortedActualJsonObject)
            
                if actualRecordCount != expectedRecordCount:
                    raise Exception('record counts are mismatched; expected ' + str(expectedRecordCount) + ', got ' + str(actualRecordCount))
            
                # if there are the right number of records, compare each one's fields
                for i in range(0, actualRecordCount - 1):
                    expectedObject = sortedExpectedJsonObject[i]
                    actualObject = sortedActualJsonObject[i]
                    for field in comparison_fields:
                        expectedValue = expectedObject[field]
                        actualValue = actualObject[field]
                        if expectedValue != actualValue:
                            raise Exception('Mismatch on value of field "{0}" in record {1}; expected "{2}", got "{3}"'.format(
                                field, i, expectedValue, actualValue))
                        
            print '  Succcess!'
            
        except Exception as e:
            print '  Failure; ' + str(e)
        



def main():
    run_post_tests()
    run_get_tests()

    
if __name__ == "__main__": 
    main()
    
    
    
    
    
    
    
    
    
    
    