/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
package org.orcid.core.manager.v3;

import java.util.List;
import java.util.Map;

import org.orcid.jaxb.model.message.OrcidMessage;
import org.orcid.jaxb.model.v3.dev1.search.Search;

/**
 * Class to retrieve OrcidMessage objects (with nested Search Results) relating
 * to all the information that could be found given the search criteria found.
 * The info needs to exist in both the search index and the Orcid DB.
 * 
 * 
 * @author jamesb
 * @See OrcidMessage
 * @See OrcidSearchResults
 * 
 */
public interface OrcidSearchManager {

    static final int DEFAULT_SEARCH_ROWS = 100;
    
    static final int MAX_SEARCH_ROWS = 200; 
    
    static final int MAX_SEARCH_START = 10000;
    
    OrcidMessage findOrcidSearchResultsById(String orcid);

    /**
     * throws OrcidSearchException if there is any error doing the search.
     */
    OrcidMessage findPublicProfileById(String orcid);

    //only ref is in test...?
    @Deprecated()
    OrcidMessage findOrcidsByQuery(String query);

    OrcidMessage findOrcidsByQuery(String query, Integer start, Integer rows);

    OrcidMessage findOrcidsByQuery(Map<String, List<String>> query);
    
    Search findOrcidIds(Map<String, List<String>> queryParameters);

}
