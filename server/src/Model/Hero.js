export interface Hero
{
    id: string,
    x: number,
    y: number,
    destinationX: number,
    destinationY: number,
    speed: number,
    heroType: number,
}

export function createHero(id: string, x: number, y: number, destinationX: number, destinationY: number, speed: number, heroType: number): Hero
{
    return {id, x, y, destinationX, destinationY, speed, heroType}
}