// index.js
// 通过require获取两个node内置模块
const http = require('http');
const nUrl = require('url');
// '127.0.0.1'表明只有本机可访问，'0.0.0.0'表示所有人可访问
const hostname = '127.0.0.1';
const port = 3000;
// 通过http.createServer获取一个server实例
// 其中(req, res) => {}，在服务器每次接收到请求时都会被执行
const server = http.createServer((req, res) => {
    let method = req.method; // 客户端请求方法
    let url = nUrl.parse(req.url); // 将请求url字符串转换为node的url对象
    // 如果客户端GET请求'/'，会执行这个分支里面的逻辑
    if (method === 'GET' && url.pathname === '/') {
        res.statusCode = 200;
        res.setHeader('Content-Type', 'text/plain');
        res.end('Hello World');
        return;
    }
    // 如果客户端GET请求'/api/user'，会执行这个分支里面的逻辑
    if (method === 'GET' && url.pathname === '/api/user') {
        res.statusCode = 200;
        res.setHeader('Content-Type', 'application/json');
        res.end(JSON.stringify({
            code: 0,
            msg: '',
            result: {
                username: 'shasharoman'
            }
        }));
        return;
    }
    // 没有匹配其他分支的话，执行以下逻辑
    res.statusCode = 404;
    res.setHeader('Content-Type', 'text/plain');
    res.end('Not Found');
});
// server开始监听，等待请求到来
server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});



/**
 * mess the cards
 */
var washCards = function(cards){
	var cards = new Array();
	for(var i = 0;i< 13;i++){
		for(var j = 1 ;j< 4; j++){
			var card = new Card(j,i);
			cards.push(card);
		}
	}
	
	return cards;
};


/**
 * define a desktop,one this can show the cards
 */

var desktop = function(){
	
	var cards = new Array();
	
};

/**
 * define a card, with the number and the type : Heart-1, Club-2 Diamond-3, Spade-4
 */
var card = function(type,number){
	
	var number = number;
	var type = type;

};

/**
 * to define a player with name ,and cards,and desktop to show what been throw out.
 */
var player = function(name){
	
	var name = name;

	var cards=new Array();
	
	var desktop = new Array();

};



/**
 * 从队列中出一张牌
 */

var pickout = function(index,cards){
	
	return cards.splice(index,1);
};

/**
 * 插入一张牌
 */
var pickin = function(card,cards){
	
	for(var i=cards.length-1;i>0;i++){

		if(card.number >= cards[i].number){

			cards.splice(i+1,0,card);

		}

	}

};











