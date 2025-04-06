# API SPEC FOR USER

## Endpoint : zequiz/auth/register (POST)
 
 - Menyimpan pengguna ke database

### request body : 
```json
{
  "username": "Jonathan",
  "grade": 4,
  "password": "rahasia123"
}
```

### response body (Success): 
```json
{
  "message" : "User registered successfully"
} 
```

### response body (Failed):
```json
{
  "message" : "Username already taken"
}
```

## Endpoint : zequiz/auth/login (POST)

- Mengotentikasi pengguna

### Request body : 
```json
{
  "username": "Jonathan",
  "password": "rahasia123"
}
```

### response body (Success) :
```json
{
  "message" : "Login successfully",
  "token": "albscsdacasdfdsaf"
}
```

### response body (Failed): 
```json
{
  "message": "Login failed"
}
```