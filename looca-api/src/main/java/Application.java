import api.entity.Cpu;
import api.entity.Memory;
import api.entity.SystemInfo;
import api.entity.Temperature;
import api.entity.groups.Disk;
import io.bretty.console.table.Alignment;
import tech.tablesaw.api.Table;

public class Application {
    public static void main(String[] args) {
        Disk disk = new Disk();
        Cpu cpu = new Cpu();
        Memory memory = new Memory();
        SystemInfo systemInfo = new SystemInfo();
        Temperature temperature = new Temperature();

//        systemInfo.showSystemInfo();
//        disk.listDisks();
//        cpu.showCpu();
//        memory.showMemory();
//        temperature.showTemperature();

    }
}
