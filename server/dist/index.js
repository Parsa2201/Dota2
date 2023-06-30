"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const http_1 = require("http");
const socket_io_1 = require("socket.io");
const EntitiesState_1 = require("./State/EntitiesState");
const httpServer = (0, http_1.createServer)();
const io = new socket_io_1.Server(httpServer, {});
const entitiesState = new EntitiesState_1.EntitiesState();
io.on('connection', (socket) => {
    entitiesState.playerConnected(socket);
    // Handle Events
    socket.on('startGame', () => entitiesState.startGame(socket));
    socket.on('playerDisconnected', () => entitiesState.playerDisconnected(socket));
    socket.on('newHero', (data) => entitiesState.newHero(socket, data));
    socket.on('heroDestinationChanged', (data) => entitiesState.heroDestinationChanged(socket, data));
    socket.on('heroSpeedChanged', (data) => entitiesState.heroSpeedChanged(socket, data));
});
httpServer.listen(8080, () => console.log('Server is now running on 8080'));
