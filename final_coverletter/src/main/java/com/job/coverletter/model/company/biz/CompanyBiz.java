package com.job.coverletter.model.company.biz;

import com.job.coverletter.model.company.dto.CompanyDto;

public interface CompanyBiz {
	public CompanyDto selectOne(int companyseq);
}
