#!/usr/bin/python3

# Usage: ./rand_generator.py amount

import sys, random, time

amount = int(sys.argv[1])
MAX_32INTEGER = 2147483647
MIN_32INTEGER = -2147483648

if len(sys.argv) > 2:
    print("Using custom random seed: {}".format(sys.argv[2]))
    random.seed(int(sys.argv[2]))

input_file = open('input_data.txt', 'w')

input_file.write(str(amount) + '\n')

print('Generate {:,} random integers'.format(amount))
tic = time.time()

for i in range(amount):
    input_file.write(str(random.randint(MIN_32INTEGER, MAX_32INTEGER)) + '\n')

toc = time.time()

input_file.close

print("Generated in {} seconds".format(round(toc - tic, 2)))