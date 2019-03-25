package com.sauro.loans.dal;

import com.sauro.loans.dal.models.BranchOfficeEntity;
import com.sauro.loans.dal.models.access.ModuleEntity;
import com.sauro.loans.dal.models.access.RoleEntity;
import com.sauro.loans.services.BranchOfficeService;
import com.sauro.loans.services.ModuleService;
import com.sauro.loans.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    RoleService roleService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    BranchOfficeService branchOfficeService;

    @Override
    public void run(String... args) throws Exception {
        // ROLES BY DEFAULT

        RoleEntity roleAdmin = new RoleEntity();
        roleAdmin.setName("Admin");
        roleAdmin.setCode("R1");
        roleAdmin.setDescription("Es un usuario que puede tiene tiene los accesos de Crear, Actualizar, Eliminar e Imprimir");
        roleAdmin.setCanCreate(Boolean.TRUE);
        roleAdmin.setCanUpdate(Boolean.TRUE);
        roleAdmin.setCanDelete(Boolean.TRUE);
        roleAdmin.setCanPrint(Boolean.TRUE);
        roleService.createRole(roleAdmin);

        RoleEntity roleCajero = new RoleEntity();
        roleCajero.setName("Cajero");
        roleCajero.setCode("R2");
        roleCajero.setDescription("Es un usuario que puede tiene tiene los accesos de Crear");
        roleCajero.setCanCreate(Boolean.TRUE);
        roleCajero.setCanUpdate(Boolean.FALSE);
        roleCajero.setCanDelete(Boolean.FALSE);
        roleCajero.setCanPrint(Boolean.FALSE);
        roleService.createRole(roleCajero);

        RoleEntity roleDespacho = new RoleEntity();
        roleDespacho.setName("Despacho");
        roleDespacho.setCode("R3");
        roleDespacho.setDescription("Es un usuario que puede tiene tiene los accesos de Imprimir");
        roleDespacho.setCanCreate(Boolean.FALSE);
        roleDespacho.setCanUpdate(Boolean.FALSE);
        roleDespacho.setCanDelete(Boolean.FALSE);
        roleDespacho.setCanPrint(Boolean.TRUE);
        roleService.createRole(roleDespacho);

        // MODULES BY DEFAULT
        ModuleEntity moduleLoans = new ModuleEntity();
        moduleLoans.setCode("M1");
        moduleLoans.setName("Libros");
        moduleLoans.setDescription("Todo respecto a libros realizados por el sistema");
        moduleService.createModule(moduleLoans);

        ModuleEntity moduleBranchOffice = new ModuleEntity();
        moduleBranchOffice.setCode("M4");
        moduleBranchOffice.setName("Sucursales");
        moduleBranchOffice.setDescription("Todo respecto a Sucursales del sistema");
        moduleService.createModule(moduleBranchOffice);

//        ModuleEntity moduleRequests = new ModuleEntity();
//        moduleRequests.setCode("S");
//        moduleRequests.setName("Solicitudes");
//        moduleRequests.setDescription("Todo respecto a Solicitudes de Garantias");
//        moduleService.createModule(moduleRequests);

        ModuleEntity moduleRoles = new ModuleEntity();
        moduleRoles.setCode("M5");
        moduleRoles.setName("Roles");
        moduleRoles.setDescription("Todo respecto a Roles del sistema");
        moduleService.createModule(moduleRoles);

        ModuleEntity moduleModules = new ModuleEntity();
        moduleModules.setCode("M6");
        moduleModules.setName("Modulos");
        moduleModules.setDescription("Todo respecto a Modulos del sistema");
        moduleService.createModule(moduleModules);

        ModuleEntity moduleUsers = new ModuleEntity();
        moduleUsers.setCode("M6");
        moduleUsers.setName("Usuarios");
        moduleUsers.setDescription("Todo respecto a Usuarios del sistema");
        moduleService.createModule(moduleUsers);

        // Branch Offices by Default
        BranchOfficeEntity branchOfficeCocha = new BranchOfficeEntity();
        branchOfficeCocha.setCode("BOF_1");
        branchOfficeCocha.setName("SUC_CID");
        branchOfficeCocha.setCity("Valencia");
        branchOfficeCocha.setAddress("Av. del Cid No.26");
        branchOfficeService.createBranchOffice(branchOfficeCocha);

        BranchOfficeEntity branchOfficeCocha2 = new BranchOfficeEntity();
        branchOfficeCocha2.setCode("BOF_2");
        branchOfficeCocha2.setName("SUC_COLON");
        branchOfficeCocha2.setCity("Valencia");
        branchOfficeCocha2.setAddress("Av. Colón No. 15");
        branchOfficeService.createBranchOffice(branchOfficeCocha2);

        BranchOfficeEntity branchOfficeCocha3 = new BranchOfficeEntity();
        branchOfficeCocha3.setCode("BOFF_3");
        branchOfficeCocha3.setName("SUC_REINO");
        branchOfficeCocha3.setCity("Valencia");
        branchOfficeCocha3.setAddress("Av. Reino de Valencia No. 88");
        branchOfficeService.createBranchOffice(branchOfficeCocha3);
    }
}
