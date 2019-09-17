var Kafka = require('node-rdkafka');

var brokers = '127.0.01:9092';
var config = {
    'client.id': 'chat-message-processor',
    'group.id': 'chat-message-processor',
    'metadata.broker.list': brokers,
    'socket.keepalive.enable': 'true'
};

var producerStream = Kafka.Producer.createWriteStream(config, {}, {
    topic: 'message-down'
});

var consumerStream = new Kafka.KafkaConsumer.createReadStream(config, {}, {
    topics: 'message-up'
});

consumerStream.on('data', function(message) {
    console.log('Got message');
    var msg = JSON.parse(message.value.toString());
    console.log(msg);
    var msgDown = processMessage(msg);
    console.log("Replying with messsage");
    console.log(msgDown);
    producerStream.write(Buffer.from(msgDown));
});





function processMessage(msg) {
    return JSON.stringify({content: "I'm node and I'm replying... " + msg.content.toLocaleUpperCase()});
}


