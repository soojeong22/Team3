package com.job.coverletter.model.coverletter.biz;

import java.util.List;

import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

public interface CoverLetterBiz {

	// 이력서 다운로드 게시판 총 게시글 수
	public int CVListCount(CoverLetterDto dto);

	// 이력서 다운로드 게시판 글 목록
	public List<CoverLetterDto> CVList(CoverLetterDto dto);

}
