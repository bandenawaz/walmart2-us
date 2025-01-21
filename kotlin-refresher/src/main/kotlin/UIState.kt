import javax.swing.plaf.nimbus.State

sealed class UIState {

    object Loading: UIState()
    data class Success(val data: String): UIState()
    data class Error(val message: String): UIState()

    fun displayUIState(state: UIState){
        when(state){
            is UIState.Loading -> println("Loading")
            is UIState.Success -> println(state.data)
            is UIState.Error -> println(state.message)
        }
    }
}

fun main(){
    val loadingState: UIState = UIState.Loading
    val successState: UIState = UIState.Success("Successfully loaded the data")
    val errorState: UIState = UIState.Error("Failed to load the data")

    loadingState.displayUIState(loadingState)
    successState.displayUIState(successState)
    errorState.displayUIState(errorState)
}