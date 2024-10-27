# Cloud App 

- It's a collection of different tech stacks
  - We have used 
  - ollama [REST chat APIs] internally uses llama3.1:8b model
  - MongoDB as NoSQL DB
  - Postgres
  - Restfull APIs
  - docker compose
  - 



**Building a Messaging Queue System with RabbitMQ and Spring Boot**

### Overview

#### Messaging

- What is a Message Queue?
  - Messaging is a communication mechanism used for system interactions.
  - Message queuing allows applications to communicate by sending messages to each other.
  - The message queue provides a temporary message storage when the destination program is busy or not connected.
  - Message queue is made up of producer, a broker(the message queue software), and a consumer.
  - Message queue provides an asynchronous communication b/w application.

  - In software development messaging enables distributed communication that is loosely coupled.
  - A messaging client can send messages to, and receive messages from, any other client.
  - The structure of message can be defined as follows-
    * Message
      * Header
      * Body
    * Synchronous Messaging
      * The messaging client sends a message and `expects` the `response immediately`
    * Asynchronous Messaging
      * The messaging client sends a message and `does not expects` the `response immediately`

    * `Real time systems` usually have a `combination` of `syschronous` and `ascynchronous` communication
    * Message Broker _[ReadMore](https://www.javainuse.com/messaging/rabbitmq/introtomessaging)_
      * These are responsible for establishing connections with different client systems.

      * Before message broker
        * If no message broker, then each telephone connection will have direct line will all other telephone connections.
        * If another telephone connection needs to be added, then all existing telephone connections will need to get a direct line with this new telephone connection.
        * As more connections are added this will get more complicated.

      * After message broker
        * All connections are registered with Message Broker
        * It will automatically route the message to the correct client based on some message configuration

### RabbitMQ

- RabbitMQ is open source message broker software
- (sometimes called message-oriented middleware)
- Acts as an intermediary platform where different applications can send and receive messages.
- Originally implements the Advanced Message Queuing Protocol (AMQP). 
  - But now it supports other API protocol like STOMP, MQTT and HTTP
- The `RabbitMQ server` is written in the Erlang programming language
- Built on the `Open Telecom Platform framework` for clustering and failover.

#### Common terminologies

- `Producer`
  - An application that sends messages to the RabbitMQ broker
- `Consumer`
  - An application that reads messages from RabbitMQ broker
- `Queue` (`RabbitMQ Broker`)
  - Is a buffer or storage in a RabbitMQ broker to store the messages.
  - Messages are put into a queue by a producer and read from it by a consumer.
  - Once a message is read, it is consumed and removed from the queue. 
  - A message can thus only be processed exactly once.  
- `Message`
  - Information that is sent from the producer to a consumer through RabbitMQ [Mostly Events]
- `Exchange`
  - intermediary between the producer and a queue.
  - instead of sending messages directly to a queue, a producer can send them to an exchange instead.
  - and exchange then sends those messages to one or more queues following specific set of rules.
- `RoutingKey`
  - Is the key that the exchange looks at to decide how to route the message to queues. 
  - Its more like an address for the message.
- `Binding`
  - A binding is a link between a queue and an exchange.


- Broker
  - Exchange + NotificationQueue
  - Consumer to consume the msgs from the Broker

  * 2 Parts
    * A message listener
      - `Which waits for messages`
    * Message publisher
      - `Which sends the message`

  * Configure rabbitMQ

### Benefits of RabbitMQ

- Loose Coupling
- Performance
- Asynchronous
- Scalability
- Language Agnostic
- Acks
- ManagementUI
- Plugins
- Cloud

### Aim:

- Implemented RabbitMQ
- Set up a messaging queue system.
- Create a simple messaging queue system using a Spring Boot project and RabbitMQ










