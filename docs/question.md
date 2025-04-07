# API SPEC FOR QUESTION

## Endpoint : zequiz/question (POST) (CREATE)

- Menyimpan question baru ke database
-  **Authorization:** Required (Bearer Token)

## Request Body:
```json
{
  "pertanyaan": "String",
  "opsiPertama": "String",
  "opsiKedua": "String",
  "opsiKetiga": "String",
  "opsiKeempat": "String",
  "jawabanBenar": "String"
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
  "message" : "Failed to Create Question"
}
```

## Endpoint : zequiz/question (GET) (READ)

- Mengambil semua daftar question yang ada di database
-  **Authorization:** Required (Bearer Token)

### Response Body (Success) :

```json
{
  "data": [
    {
      "questionId": 10,
      "questionTopicId": 1,
      "pertanyaan": "String",
      "opsiPertama": "String",
      "opsiKedua": "String",
      "opsiKetiga": "String",
      "opsiKeempat": "String",
      "jawabanBenar": "String"
    },
    {
      "questionId": 10,
      "questionTopicId": 1,
      "pertanyaan": "String",
      "opsiPertama": "String",
      "opsiKedua": "String",
      "opsiKetiga": "String",
      "opsiKeempat": "String",
      "jawabanBenar": "String"
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

## Endpoint : zequiz/question (PATCH)

- Mengubah nama topic
- **Authorization:** Required (Bearer Token)

### Request Parameters:

| Parameter    | Type  | Required | Description                       |
|--------------|-------|----------|-----------------------------------|
| `questionId` | `int` | Yes      | The ID of the question to update. |

### Request Body:
```json
{
  "pertanyaan": "String",
  "opsiPertama": "String",
  "opsiKedua": "String",
  "opsiKetiga": "String",
  "opsiKeempat": "String",
  "jawabanBenar": "String"
}
```

### Response Body (Success) :
```json
{
  "message" : "Question Updated Successfully"
}
```

### Response Body (Failed) :
```json
{
  "message" : "Question Updated Failed"
}
```

## Endpoint : zequiz/question (DELETE)
- Menghapus
- **Authorization** : Required (Bearer Token)

### Request Parameters:

| Parameter    | Type  | Required | Description                       |
|--------------|-------|----------|-----------------------------------|
| `questionId` | `int` | Yes      | The ID of the question to delete. |

## Response Body (Success) :

```json
{
  "message" : "Question Deleted Successfully"
}
```

## Response Body (Failed) :

```json
{
  "message" : "Question Deleted Failed"
}
```










