package demo.mocking

interface BARepository {
    fun getAll(): List<BA>
    fun getById(id: Int): BA
    fun insert(acc: BA): Int
    fun update(id: Int, acc: BA)
    fun delete(id: Int)
}