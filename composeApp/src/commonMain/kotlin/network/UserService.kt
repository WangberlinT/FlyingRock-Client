package network

interface UserService {
    suspend fun register(username: String, password: String)
}