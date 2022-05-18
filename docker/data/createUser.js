db.createUser(
{
    user: "customUser",
    pwd: "pass",
    roles: [
      { role: "readWrite", db: "mongoDefault" }
    ]
}
);

db.createCollection('person');

persons = [
{
    "_id":4,
    "firstName":"name1",
    "secondName":"name2",
    "age":34,
    "interests":["marketing", "swim", "math"],
    "weight":70.00
},
{
    "_id":5,
    "firstName":"name2",
    "secondName":"name2",
    "age":34,
    "interests":["marketing", "swim", "history"],
    "weight":70.00
},
{
    "_id":6,
    "firstName":"name3",
    "secondName":"name3",
    "age":34,
    "interests":["marketing", "swim", "painting"],
    "weight":70.00
}
];

db.person.insertMany(persons);



