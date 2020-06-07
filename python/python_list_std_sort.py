#!/usr/bin/python3

# Usage:
# ./python_std_sort.py list|array|np_array

import time, array, numpy, sys

def getDataStructure(size):
    structure = sys.argv[1]
    data = []
    for _ in range(size):
        data.append(int(input_data.readline()))
    if structure == 'list': return data
    if structure == 'array': return array.array('i', data)
    if structure == 'np_array': return numpy.array(data, dtype=int)

input_data = open('../input_data.txt', 'r')

size = int(input_data.readline())

input_data.close

data = getDataStructure(size)

print('{:,} integers have been loaded into {}'.format(len(data), type(data)))

tic = round(time.time() * 1000, 2)
sorted(data)
toc = round(time.time() * 1000, 2)

print("\n==>%.2f" % (toc - tic))