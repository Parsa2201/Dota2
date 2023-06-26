import {createHero, Hero} from "../Model/Hero";
import {Socket} from "socket.io";

export class EntitiesState
{
    private heroes: Hero[] = [];
    private playerIds: string[] = [];

    private getHero(id: string): Hero
    {
        const heroIndex = this.heroes.findIndex(h => h.id === id);
        return this.heroes[heroIndex];
    }

    public playerConnected(socket: Socket): void
    {
        console.log('Player connected: ' + socket.id);
        socket.emit('mySocketId', {id: socket.id});
        socket.broadcast.emit('newPlayer', {id: socket.id});
        this.playerIds.push(socket.id);
    }

    public startGame(socket: Socket): void
    {
        console.log('The game started with ' + this.playerIds.length + ' players');
        socket.broadcast.emit('startGame');
    }

    public playerDisconnected(socket: Socket): void
    {
        socket.broadcast.emit('disconnect', {id: socket.id});
        console.log('Player disconnected: ' + socket.id);
        this.playerIds = this.playerIds.filter(id => id !== socket.id);
    }

    public newHero(socket: Socket, data: any): void
    {
        console.log('Hero added: id: ' + socket.id);
        const x = data.x;
        const y = data.y;
        const destinationX = data.destinationX;
        const destinationY = data.destinationY;
        const speed = data.speed;
        const heroType = data.heroType;
        const hero = createHero(socket.id, x, y, destinationX, destinationY, speed, heroType);
        socket.broadcast.emit('newHero', hero);
        this.heroes.push(hero);
    }

    public heroDestinationChanged(socket: Socket, data: any): void
    {
        console.log('Hero destination changed: id: ' + socket.id, ' , x: ' + data.destinationX + ' , y: ' + data.destinationY);
        data.id = socket.id;
        socket.broadcast.emit('heroDestinationChanged', data);

        const destinationX = data.destinationX;
        const destinationY = data.destinationY;
        const hero = this.getHero(data.id);
        hero.destinationX = destinationX;
        hero.destinationY = destinationY;
    }

    public heroSpeedChanged(socket: Socket, data: any): void
    {
        console.log('Hero speed changed: id: ' + socket.id + ' , speed: ' + data.speed);
        data.id = socket.id;
        socket.broadcast.emit('heroSpeedChanged', data);

        const hero = this.getHero(data.id);
        hero.speed = data.speed;
    }
}