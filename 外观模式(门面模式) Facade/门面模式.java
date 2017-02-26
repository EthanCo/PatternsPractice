class CPU {
public void freeze() { ... }
public void jump(long position) { ... }
public void execute() { ... }
}
class Memory {
public void load(long position, byte[] data) {
...
}
}
class HardDrive {
public byte[] read(long lba, int size) {
...
}
}
/* Fa&ccedil;ade */
class Computer {
public void startComputer() {
cpu.freeze();
memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
cpu.jump(BOOT_ADDRESS);
cpu.execute();
}
}
/* Client */
class You {
public static void main(String[] args) {
Computer facade = new Computer();
facade.startComputer();
}
}