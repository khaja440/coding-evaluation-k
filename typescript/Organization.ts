import Position from './Position';
import Name from './Name';
import Employee from './Employee';

abstract class Organization {
  private root: Position;
  EmpId: number;

  constructor() {
    this.root = this.createOrganization();
  }

  protected abstract createOrganization(): Position;

  printOrganization = (position: Position, prefix: string): string => {
    let str = `${prefix}+-${position}\n`;
    for (const p of position.getDirectReports()) {
      str = str.concat(this.printOrganization(p, `${prefix}  `));
    }
    return str;
  };

  // Hire the given person as an employee in the position that has that title
  // Return the newly filled position or undefined if no position has that title
  hire(person: Name, title: string): Position | undefined {
    
    const emp=new Employee(this.EmpId,person);
    const pos=new Position(title,emp);
    console.log(pos.toString());
    this.EmpId++;
    return pos;
 
  }

  toString = () => this.printOrganization(this.root, '');
}

export default Organization;
