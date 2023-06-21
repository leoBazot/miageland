package com.appent.miageland.export;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CompteEmployeExport extends CompteExport {
    private TypeEmploye typeEmploye;
}
