package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.dtos.listDtos.ListInvoiceDto;
import com.example.rentACar.business.requests.createRequests.CreateInvoiceRequest;
import com.example.rentACar.business.requests.deleteRequests.DeleteInvoiceRequest;
import com.example.rentACar.business.requests.updateRequests.UpdateInvoiceRequest;
import com.example.rentACar.core.results.DataResult;
import com.example.rentACar.core.results.Result;

public interface InvoiceService {

	DataResult<List<ListInvoiceDto>> getAll();
	Result create(CreateInvoiceRequest createInvoiceRequest);
	Result delete(DeleteInvoiceRequest deleteInvoiceRequest);
	Result update(UpdateInvoiceRequest updateInvoiceRequest);

}
