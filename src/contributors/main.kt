package contributors

fun main() {
    println("main running in ${Thread.currentThread().name}")
    setDefaultFontSize(18f)
    ContributorsUI().apply {
        pack()
        setLocationRelativeTo(null)
        isVisible = true
    }
}