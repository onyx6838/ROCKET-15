class Department {
    static id: number = 0;
    name: string;

    constructor(name: string) {
        Department.id++;
        this.name = name;
    }

    getName(): string {
        return this.name;
    }

}

enum PositionName {
    DEV, TEST, SCRUM_MASTER, PM
}

class Position {
    static id: number = 0;
    name: PositionName;
    constructor(name: PositionName) {
        this.name = name;
    }

    getPosition(): PositionName {
        return this.name;
    }
}

class Account {
    static id: number = 0;
    email: string;
    userName: string;
    fullName: string;
    department: Department;
    position: Position;
    createDate: Date;

    constructor(fullName: string, department: Department, position: Position, createDate: Date) {
        Account.id++;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
    }

    toString(): string {
        return "Name " + this.fullName + "\n" +
            " Position { ID: "  + Position.id  + " ,Name: " + this.position.getPosition() + "}\n" + 
            " Department {ID: " + Department.id + " ,Name: " + this.department.getName() + "}";
    }
}

const d = new Department("dp1");

const p = new Position(PositionName.DEV);
const p1 = new Position(PositionName.PM);

const a = new Account("account1", d, p1, new Date());

console.log(a.toString());