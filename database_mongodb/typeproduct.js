db = db.getSiblingDB("ModernAgriculture");
db.TypeProduct.drop();
db.TypeProduct.insertMany([
    {
        "TypeProdcutID": 1,
        "NameTypeProdct": "Quạt gió và quạt trần",
        "TypeParentId": 1
    },
    {
        "TypeProdcutID": 2,
        "NameTypeProdct": "Máy tính và chuột",
        "TypeParentId": 1
    },
    {
        "TypeProdcutID": 3,
        "NameTypeProdct": "Quạt gió và quạt trần",
        "TypeParentId": 1
    },
    {
        "TypeProdcutID": 4,
        "NameTypeProdct": "Sách giáo khoa",
        "TypeParentId": 1
    },
    {
        "TypeProdcutID": 5,
        "NameTypeProdct": "Tap",
        "TypeParentId": 1
    },
]);