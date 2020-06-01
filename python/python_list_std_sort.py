#!/usr/bin/python3

# Usage:
# ./python_std_sort.py list|array|np_array

import time, array, numpy, sys

def getDataStructure(size):
    structure = sys.argv[1]
    data = []
    for _ in range(size):
        data.append(int(input_data.readline()))
    if structure == 'list':
        return data
    elif structure == 'array':
        return array.array('i', data)
    elif structure == 'np_array':
        return numpy.array(data, dtype=int)

input_data = open('../input_data.txt', 'r')

size = int(input_data.readline())

input_data.close

data = getDataStructure(size)
print("Using {} for test".format(type(data)))
print('{:,} integers have been loaded into memory'.format(len(data)))

tic = time.time()
sorted(data)
toc = time.time()

print("\n==> sorted in {} seconds <==".format(round(toc - tic, 2)))