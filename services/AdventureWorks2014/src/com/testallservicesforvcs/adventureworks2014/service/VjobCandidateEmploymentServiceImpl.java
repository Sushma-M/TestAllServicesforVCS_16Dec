/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testallservicesforvcs.adventureworks2014.VjobCandidateEmployment;
import com.testallservicesforvcs.adventureworks2014.VjobCandidateEmploymentId;


/**
 * ServiceImpl object for domain model class VjobCandidateEmployment.
 *
 * @see VjobCandidateEmployment
 */
@Service("AdventureWorks2014.VjobCandidateEmploymentService")
public class VjobCandidateEmploymentServiceImpl implements VjobCandidateEmploymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VjobCandidateEmploymentServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2014.VjobCandidateEmploymentDao")
    private WMGenericDao<VjobCandidateEmployment, VjobCandidateEmploymentId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VjobCandidateEmployment, VjobCandidateEmploymentId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public VjobCandidateEmployment getById(VjobCandidateEmploymentId vjobcandidateemploymentId) throws EntityNotFoundException {
        LOGGER.debug("Finding VjobCandidateEmployment by id: {}", vjobcandidateemploymentId);
        VjobCandidateEmployment vjobCandidateEmployment = this.wmGenericDao.findById(vjobcandidateemploymentId);
        if (vjobCandidateEmployment == null){
            LOGGER.debug("No VjobCandidateEmployment found with id: {}", vjobcandidateemploymentId);
            throw new EntityNotFoundException(String.valueOf(vjobcandidateemploymentId));
        }
        return vjobCandidateEmployment;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public VjobCandidateEmployment findById(VjobCandidateEmploymentId vjobcandidateemploymentId) {
        LOGGER.debug("Finding VjobCandidateEmployment by id: {}", vjobcandidateemploymentId);
        return this.wmGenericDao.findById(vjobcandidateemploymentId);
    }


	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<VjobCandidateEmployment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VjobCandidateEmployments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<VjobCandidateEmployment> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VjobCandidateEmployments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table VjobCandidateEmployment to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

