# Exposed-Dropdown-Input
Android (Compose) library that provides the exposed dropdown menu like this:
- ![Screenshot 2023-08-19 132333](https://github.com/YoussefMoataz/Exposed-Dropdown-Input/assets/50296580/7ac1561a-533b-47bd-9b50-a8ba668dc2be)
- ![Screenshot 2023-08-19 132359](https://github.com/YoussefMoataz/Exposed-Dropdown-Input/assets/50296580/cc8eb126-72fd-48a2-b629-36b626b3e4cb)

## Setup
``` gradle
dependencies {
    implementation("com.github.YoussefMoataz:Exposed-Dropdown-Input:1.0.0")
}
```

## Usage
``` Kotlin
val inputValue = rememberExposedDropdownValue()

ExposedDropdownMenu(
    label = "Language",
    text = inputValue.value,
    onValueChange = { newValue ->
        inputValue.value = newValue
    },
    items = arrayListOf("Kotlin", "Java"),
    isError = false,
    supportingText = {
        Text(text = "Instructions")
    }
)
```
