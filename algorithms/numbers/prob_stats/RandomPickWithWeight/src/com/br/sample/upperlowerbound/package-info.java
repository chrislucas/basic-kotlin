package com.br.sample.upperlowerbound;

/**
 * possivel implementacao em cpp
 * https://en.cppreference.com/w/cpp/algorithm/lower_bound
 * https://en.cppreference.com/w/cpp/algorithm/upper_bound
 *
 * exemplo de uso
 * https://www.geeksforgeeks.org/lower_bound-in-cpp/
 * https://www.geeksforgeeks.org/upper_bound-in-cpp/
 *
 * Pesquisar por
 * algorithm to choose number with bias
 *
 * Pesquisar por
 * algorithm generate random number withweight
 * https://en.wikipedia.org/wiki/Reservoir_sampling
 * https://softwareengineering.stackexchange.com/questions/233541/how-to-implement-a-weighted-shuffle
 *
 * Random Picking problem
 * https://www.tutorialspoint.com/random-pick-with-weight-in-cplusplus
 *
 * https://stackoverflow.com/questions/3679694/a-weighted-version-of-random-choice
 *
 * https://medium.com/swlh/random-pick-with-weight-leetcode-june-2020-challenge-4fc461922a02
 * https://stackoverflow.com/questions/1761626/weighted-random-numbers
 * https://massivealgorithms.blogspot.com/2018/12/leetcode-528-random-pick-with-weight.html
 * https://stackoverflow.com/questions/6409652/random-weighted-selection-in-java
 *
 * Pesquisar por
 * random pick with probability distribution
 * */


/**
 * arrayOf(0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5) -> idx 0:sizeof(array)
 * i = 0 -> lo = 0 : up = 1
 * i = 1 -> lo = 1 : up = 3
 * i = 2 -> lo = 3 : up = 6
 * i = 3 -> lo = 6 : up = 9
 * i = 4 -> lo = 9 : up = 10
 * i = 5 -> lo = 10 : up = sem resposta
 * i = 6 -> lo = sem resposta : up = sem resposta
 * */


/**
 * arrayOf(0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5) -> idx 0:sizeof(array)
 * i = 0 -> lo = 0 : up = 1
 * i = 1 -> lo = 1 : up = 3
 * i = 2 -> lo = 3 : up = 6
 * i = 3 -> lo = 6 : up = 11
 * i = 4 -> lo = 11 : up = 14
 * i = 5 -> lo = 14 : up = sem resposta
 * i = 6 -> lo = sem resposta : up = sem resposta
 * */

