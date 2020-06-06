# Running instruction
## C++
### Compiling

```bash
cd cpp/ && g++ main.cpp -o test.out
```
or with the optimization level flag:

```bash
cd cpp/ && g++ main.cpp -O2 -o test.out
...
cd cpp/ && g++ main.cpp -O3 -o test.out
```

### Running
```bash
../executor.sh [tries] "./test.out [container_type]"
```

where:
- **tries** - numbers of sequential tests
- **container_type** - which can be:
  - **array** - dynamically allocated array: `int* data = new int[SIZE];`
  - **std_vector** - standard library vector: `std::vector<int>`
  - **std_list** - standard library linked list: `std::list<int>`
  - **std_valarray** - standard library container optimized for mathematical purposes: `std::valarray<int>`

Example:
```bash
../executor.sh 5 "./test.out std_vector"
```