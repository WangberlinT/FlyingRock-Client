package network

import io.ktor.client.HttpClient
import kotlinx.coroutines.withContext

class UserServiceImpl() : UserService{
    override suspend fun register(username: String, password: String) {
        val client = HttpClient() //TODO optimise
    }
}