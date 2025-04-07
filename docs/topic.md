# API SPEC FOR TOPIC

## Endpoint : zequiz/topic (POST) (CREATE)

- Menyimpan topik baru ke database
-  **Authorization:** Required (Bearer Token)

## Request Body:
```json
{
  "topicName": "Bahasa Inggris"
}
```

### Response Body (Success): 
```json
{
  "message" : "Created Successfully"
}
```

### Response Body (Failed):
```json
{
  "message" : "Failed to Create Topic"
}
```

## Endpoint : zequiz/topic (GET) (READ)

- Mengambil semua daftar topic yang ada di database
-  **Authorization:** Required (Bearer Token)

### Response Body (Success) :

```json
{
  "data": [
    {
      "topicId": 10,
      "topicName": "Bahasa Inggris"
    },
    {
      "topicId": 20,
      "topicName": "Bahasa Indonesia"
    }
  ],
  "message" : "Success"
}
```

### Response Body (Failed) :
```json
{
  "data": [],
  "message" : "Failed"
}
```

## Endpoint : zequiz/topic (PUT) 

- Mengubah nama topic
- **Authorization:** Required (Bearer Token)

### Path Variable:

| Parameter | Type  | Required | Description                    |
|-----------|-------|----------|--------------------------------|
| `topicId` | `int` | Yes      | The ID of the topic to update. |

### Request Body:
```json
{
  "topicName": "Matematika"
}
```

### Response Body (Success) : 
```json
{
  "message" : "Topic Updated Successfully"
}
```

### Response Body (Failed) :
```json
{
  "message" : "Topic Updated Failed"
}
```

## Endpoint : zequiz/topic (DELETE)
- Menghapus
- **Authorization** : Required (Bearer Token)

### Path Variable:

| Parameter | Type  | Required | Description                    |
|-----------|-------|----------|--------------------------------|
| `topicId` | `int` | Yes      | The ID of the topic to delete. |

## Response Body (Success) :

```json
{
  "message" : "Topic Deleted Successfully"
}
```

## Response Body (Failed) :

```json
{
  "message" : "Topic Deleted Failed"
}
```










