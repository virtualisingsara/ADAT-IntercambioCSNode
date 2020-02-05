var exp = require('express')
var mysql = require('mysql')
var bdyparser = require('body-parser')
var app = exp()
app.use(bdyparser.json())
app.use(bdyparser.urlencoded({extended:false}))

var connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "pokemon"
})

app.listen(11700, () => {
    console.log("Server iniciado.")
})

//CRUD -> Create
app.post("/pokemon", (req, res)=> {
    var nombre = req.body.nombre
    var tipo = req.body.tipo
    var gen = req.body.gen
    connection.query(`INSERT INTO pokemon (Nombre, Tipo, Gen) VALUES ('${nombre}', '${tipo}', '${gen}')`, function (err, result, fields) {
    res.json(result)})
})

//CRUD -> Read all
app.get("/pokemon", (req, res)=> {
    connection.query("SELECT * FROM pokemon", function (err, result, fields) {
    res.json(result)})
})


//CRUD -> Read one
app.get("/pokemon/:id", (req, res)=> {
    connection.query(`SELECT * FROM pokemon WHERE id = ${req.params.id}`, function (err, result, fields) {
    res.json(result)})
})

//CRUD -> Update
app.put("/pokemon/:id", (req, res)=> {
    var nombre = req.body.nombre
    var tipo = req.body.tipo
    var gen = req.body.gen
    connection.query(`UPDATE pokemon SET nombre = '${nombre}', tipo = '${tipo}', gen = '${gen}' WHERE id = ${req.params.id}`, function (err, result, fields) {
    res.json(result)})
})


//CRUD -> Delete
app.delete("/pokemon/:id", (req, res)=> {
    connection.query(`DELETE FROM pokemon WHERE id = ${req.params.id}`, function (err, result, fields) {
    res.json(result)})
})