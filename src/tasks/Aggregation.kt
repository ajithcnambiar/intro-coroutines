package tasks

import contributors.User

/*
TODO: Write aggregation code.

 In the initial list each user is present several times, once for each
 repository he or she contributed to.
 Merge duplications: each user should be present only once in the resulting list
 with the total value of contributions for all the repositories.
 Users should be sorted in a descending order by their contributions.

 The corresponding test can be found in test/tasks/AggregationKtTest.kt.
 You can use 'Navigate | Test' menu action (note the shortcut) to navigate to the test.
*/
fun List<User>.aggregate(): List<User> {
    return this.groupingBy { it.login }
        .foldTo(mutableMapOf(), emptyList<User>()){acc,e -> acc + e}
        .flatMap{ mutableListOf(User(it.key, it.value.fold(0){acc, e -> acc + e.contributions}))}
        .sortedByDescending { it.contributions }
}
