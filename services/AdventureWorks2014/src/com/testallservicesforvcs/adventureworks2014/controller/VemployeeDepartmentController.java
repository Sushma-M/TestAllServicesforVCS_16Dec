/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.testallservicesforvcs.adventureworks2014.VemployeeDepartment;
import com.testallservicesforvcs.adventureworks2014.VemployeeDepartmentId;
import com.testallservicesforvcs.adventureworks2014.service.VemployeeDepartmentService;

/**
 * Controller object for domain model class VemployeeDepartment.
 * @see VemployeeDepartment
 */
@RestController("AdventureWorks2014.VemployeeDepartmentController")
@Api(value = "VemployeeDepartmentController", description = "Exposes APIs to work with VemployeeDepartment resource.")
@RequestMapping("/AdventureWorks2014/VemployeeDepartment")
public class VemployeeDepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VemployeeDepartmentController.class);

    @Autowired
    @Qualifier("AdventureWorks2014.VemployeeDepartmentService")
    private VemployeeDepartmentService vemployeeDepartmentService;

    @ApiOperation(value = "Returns the VemployeeDepartment instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VemployeeDepartment getVemployeeDepartment(@RequestParam("businessEntityId") Integer businessEntityId, @RequestParam("title") String title, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, @RequestParam("lastName") String lastName, @RequestParam("suffix") String suffix, @RequestParam("jobTitle") String jobTitle, @RequestParam("department") String department, @RequestParam("groupName") String groupName, @RequestParam("startDate") Date startDate) throws EntityNotFoundException {
        VemployeeDepartmentId vemployeedepartmentId = new VemployeeDepartmentId();
        vemployeedepartmentId.setBusinessEntityId(businessEntityId);
        vemployeedepartmentId.setTitle(title);
        vemployeedepartmentId.setFirstName(firstName);
        vemployeedepartmentId.setMiddleName(middleName);
        vemployeedepartmentId.setLastName(lastName);
        vemployeedepartmentId.setSuffix(suffix);
        vemployeedepartmentId.setJobTitle(jobTitle);
        vemployeedepartmentId.setDepartment(department);
        vemployeedepartmentId.setGroupName(groupName);
        vemployeedepartmentId.setStartDate(startDate);
        LOGGER.debug("Getting VemployeeDepartment with id: {}", vemployeedepartmentId);
        VemployeeDepartment vemployeeDepartment = vemployeeDepartmentService.getById(vemployeedepartmentId);
        LOGGER.debug("VemployeeDepartment details with id: {}", vemployeeDepartment);
        return vemployeeDepartment;
    }

    /**
     * @deprecated Use {@link #findVemployeeDepartments(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of VemployeeDepartment instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VemployeeDepartment> searchVemployeeDepartmentsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VemployeeDepartments list");
        return vemployeeDepartmentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of VemployeeDepartment instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VemployeeDepartment> findVemployeeDepartments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VemployeeDepartments list");
        return vemployeeDepartmentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVemployeeDepartments(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return vemployeeDepartmentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of VemployeeDepartment instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countVemployeeDepartments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting VemployeeDepartments");
        return vemployeeDepartmentService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VemployeeDepartmentService instance
	 */
    protected void setVemployeeDepartmentService(VemployeeDepartmentService service) {
        this.vemployeeDepartmentService = service;
    }
}
