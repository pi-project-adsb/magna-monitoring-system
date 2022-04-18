import api.entity.Cpu;
import api.entity.Memory;
import api.entity.SystemInfo;
import api.entity.Temperature;
import api.entity.groups.Disk;
import api.entity.groups.Process;
import api.entity.groups.Service;
import io.bretty.console.table.Alignment;
import tech.tablesaw.api.Table;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Disk disk = new Disk();
        Cpu cpu = new Cpu();
        Memory memory = new Memory();
        SystemInfo systemInfo = new SystemInfo();
        Temperature temperature = new Temperature();
        Process process = new Process();
        Service service = new Service();

//        systemInfo.showSystemInfo();
//        disk.listDisks();
//        cpu.showCpu();
//        process.listProcess();
//        temperature.showTemperature();
//        service.listServices();
//        memory.showMemory();

        while (true) {
            memory.saveMemory();
            cpu.saveCpu();
        }
    }
}
