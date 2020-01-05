package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import kotlin.concurrent.thread

fun loadContributorsBackground(service: GitHubService, req: RequestData, updateResults: (List<User>) -> Unit) {
    thread {
        println("loadContributorsBackground running in ${Thread.currentThread().name}")
        updateResults(loadContributorsBlocking(service, req))
    }
}