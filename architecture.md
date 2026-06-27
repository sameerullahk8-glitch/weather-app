```mermaid
flowchart TD
    A[Start] --> B[User enters city]
    B --> C{City valid?}
    C -- Yes --> D[Call Weather API]
    C -- No --> E[Show error message]
    D --> F[Display weather data]
```
