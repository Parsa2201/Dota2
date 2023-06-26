"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.EntitiesState = void 0;
const Hero_1 = require("../Model/Hero");
class EntitiesState {
    constructor() {
        this.heroes = [];
        this.playerIds = [];
    }
    getHero(id) {
        const heroIndex = this.heroes.findIndex(h => h.id === id);
        return this.heroes[heroIndex];
    }
    playerConnected(socket) {
        console.log('Player connected: ' + socket.id);
        socket.emit('mySocketId', { id: socket.id });
        socket.broadcast.emit('newPlayer', { id: socket.id });
        this.playerIds.push(socket.id);
    }
    startGame(socket) {
        console.log('The game started with ' + this.playerIds.length + ' players');
        socket.broadcast.emit('startGame');
    }
    playerDisconnected(socket) {
        socket.broadcast.emit('playerDisconnected', { id: socket.id });
        console.log('Player disconnected: ' + socket.id);
        this.playerIds = this.playerIds.filter(id => id !== socket.id);
    }
    newHero(socket, data) {
        console.log('Hero added: id: ' + socket.id);
        const x = data.x;
        const y = data.y;
        const destinationX = data.destinationX;
        const destinationY = data.destinationY;
        const speed = data.speed;
        const heroType = data.heroType;
        const hero = (0, Hero_1.createHero)(socket.id, x, y, destinationX, destinationY, speed, heroType);
        socket.broadcast.emit('newHero', hero);
        this.heroes.push(hero);
    }
    heroDestinationChanged(socket, data) {
        console.log('Hero destination changed: id: ' + socket.id, ' , x: ' + data.destinationX + ' , y: ' + data.destinationY);
        data.id = socket.id;
        socket.broadcast.emit('heroDestinationChanged', data);
        const destinationX = data.destinationX;
        const destinationY = data.destinationY;
        const hero = this.getHero(data.id);
        hero.destinationX = destinationX;
        hero.destinationY = destinationY;
    }
    heroSpeedChanged(socket, data) {
        console.log('Hero speed changed: id: ' + socket.id + ' , speed: ' + data.speed);
        data.id = socket.id;
        socket.broadcast.emit('heroSpeedChanged', data);
        const hero = this.getHero(data.id);
        hero.speed = data.speed;
    }
}
exports.EntitiesState = EntitiesState;
