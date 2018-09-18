let express = require('express');
let app = express();
const http = require('http');
var bodyParser = require('body-parser');
const assert = require('assert');
const f = require('util').format;
const fs = require('fs');

// Read the certificate authority
// const ca = [fs.readFileSync(__dirname+"/ssl/ca.pem")];
// const cert = fs.readFileSync(__dirname + "/ssl/client.pem");

/**
 * + string connect with database mongodb.
 * + call libary mongoDB and create object for it.
 */

let url = "mongodb+srv://TienHao:Hao01021997@cluster0-3hrep.mongodb.net/test?retryWrites=true";
let mongoClient = require('mongodb').MongoClient;
const dbName = 'ModernAgriculture';

/**
 * + support json encodes bodies
 * + suppport encode bodies
 */

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

/** 
 * + install data with utf-8
 * + connect database with mongodb name is ModernAgriculture
 * + quyery all data in table TypeProdct
 * + switch json
 * + close connect
*/
app.get('*/typeproduct', (_req, res) => {
 // res.writeHead(200, {  'Content-Type': 'text/json; charset=utf-8' });

    mongoClient.connect(url, function(err, db) {
        if (err) {
            throw err;
        }
        let dbo = db.db("ModernAgriculture");

        dbo.collection("TypeProduct").find({}).toArray(function(err, result) {
            if (err) {
                throw err;
            }
            // let jsonResult = JSON.stringify(result);
            // console.log(result);
            res.send({
                LoaiSanPham: [result]
            });
            db.close();
        });
    });
});

// app.get('/product', (req, res) => {    
//     mongoClient.connect(url, {
//         server: {
//             sslValidate: true,
//             sslCA: ca,
//             sslCert: cert
//         }
//     }, function(err, client) {
//         assert.equal(null, err);
//         console.log("connected correctly to server :))");
        
//         client.close();
//     });
// });

// Assign a default Collation to a Collection

app.get('/createCollation', (req, res) => {
    mongoClient.connect(url, function(err, client) {
        console.log("Connected correctly to server");

        const db = client.db(dbName);

        createCollated(db, function() {
            client.close();
        });
    });
});

function createCollated(db, callback) {
    db.createCollection('contacts', {
        'collation': { 'locale': 'fr_CA' }
    }, function(err, result){
        console.log("Collection crated");
        callback();
    })
}

/**
 * Assign a Default collation to an index.
 */

 app.get('/assignDefaultCollation', (req, res) => {
    // Use connect method to connect to the Server
        mongoClient.connect(url, function(err, client) {
        assert.equal(null, err);
        console.log("Connected correctly to server");

        const db = client.db(dbName);

        createCollatedIndex(db, function() {
            client.close();
        });
    });
 });

 function createCollatedIndex(db, callback) {
    // Get the contacts collection
    const collection = db.collection('contacts');
    // Create the index
    collection.createIndex(
      { 'name' : 1 },
      { 'unique' : 1 },
      { 'collation' : { 'locale' : 'en_US' } }, function(err, result) {
        console.log(result);
        callback();
    });
  };

/** 
 * start server with port myseft defined
*/
const post = process.env.PORT || 3000;
const server = http.createServer(app);

server.listen(post);