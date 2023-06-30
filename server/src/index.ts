import {createServer} from "http";
import {Server, Socket} from "socket.io"
import {EntitiesState} from "./State/EntitiesState";


const httpServer = createServer();
const io = new Server(httpServer, {});
const entitiesState = new EntitiesState();

io.on('connection', (socket: Socket) =>
{
    entitiesState.playerConnected(socket);

    // Handle Events
    socket.on('startGame', () => entitiesState.startGame(socket));
    socket.on('playerDisconnected', () => entitiesState.playerDisconnected(socket));
    socket.on('newHero', (data) => entitiesState.newHero(socket, data));
    socket.on('heroDestinationChanged', (data) => entitiesState.heroDestinationChanged(socket, data));
    socket.on('heroSpeedChanged', (data) => entitiesState.heroSpeedChanged(socket, data));
})

httpServer.listen(8080, () => console.log('Server is now running on 8080'));