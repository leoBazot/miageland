package com.appent.miageland.export;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorExport {
    private String message;

    private String errorName;
}
