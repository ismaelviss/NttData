package com.ismaelviss.nttdata.application.port.in;

import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.ReportMovement;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.List;

public interface ReportServicePort {

    List<ReportMovement> getReport(String accountNumber, LocalDate startDate, LocalDate endDate) throws ApplicationException;
}
