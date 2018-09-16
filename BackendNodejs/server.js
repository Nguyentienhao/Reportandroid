let express = require('express');
let app = express();
const http = require('http');
var bodyParser = require('body-parser');
/**
 * + string connect with database mongodb.
 * + call libary mongoDB and create object for it.
 */
let url = "mongodb+srv://TienHao:Hao01021997@cluster0-3hrep.mongodb.net/test?retryWrites=true";
let mongoClient = require('mongodb').MongoClient;
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
 //  res.writeHead(200, {  'Content-Type': 'text/json; charset=utf-8' });

    mongoClient.connect(url, function(err, db) {
        if (err) throw err;
        let dbo = db.db("ModernAgriculture");

        dbo.collection("TypeProduct").find({}).toArray(function(err, result) {
            if (err) throw err;
           //  let jsonResult = JSON.stringify(result);
            // console.log(result);
            res.send({
                LoaiSanPham: [result]
            });
            db.close();
        });
    });

});


/** 
 * start server with port myseft defined
*/
const post = process.env.PORT || 3000;
const server = http.createServer(app);

server.listen(post);