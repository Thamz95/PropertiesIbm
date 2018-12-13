/*****************************************************************************/
/*  File: PSXLoadGroupListTypeTransport.java
/**********************************************************************************
/* Author Id  Generic/Branch  MR / Date        Comments
/* -----------------------------------------------------------------------------
/* jaya     2010.1.0    imr091910   Initial Add
/* th2695   2015.10.0 08/18/15   Move from spp.bvoip.transports
/*                             to spp.gcp.transports.
 * pd1363   2018.04.0 12/19/17 300375 SPP-61728 - added setters
 */
/*********************************************************************************/


import java.util.*;

import spp.platform.*;

public class PSXLoadGroupListTypeTransport implements Comparable<PSXLoadGroupListTypeTransport>, java.io.Serializable
{

	/**
	 * 
	 */
	public static final long serialVersionUID = 4491301414194025411L;
	public String loadGroupName = ""; 
	public String psxId = ""; 
	public String signalingIpAddress = "";
	public String fqdn = ""; 

	// default constructor
	public PSXLoadGroupListTypeTransport() {};

	//--------------------
	//   Getters / Setters
	//--------------------

	public String  getLoadGroupName() {return loadGroupName; }
	public void setLoadGroupName(String loadGroupName) {this.loadGroupName = loadGroupName;}

	public String  getPsxId()  {return psxId; }
	public void setPsxId(String psxId) {this.psxId = psxId;}

	public String  getSignalingIpAddress() {return signalingIpAddress; }
	public void setSignalingIpAddress(String signalingIpAddress) {this.signalingIpAddress = signalingIpAddress;}

	public String getFqdn() {return fqdn;	}
	public void setFqdn(String fqdn) {this.fqdn = fqdn;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fqdn == null) ? 0 : fqdn.hashCode());
		result = prime * result + ((loadGroupName == null) ? 0 : loadGroupName.hashCode());
		result = prime * result + ((psxId == null) ? 0 : psxId.hashCode());
		result = prime * result + ((signalingIpAddress == null) ? 0 : signalingIpAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PSXLoadGroupListTypeTransport other = (PSXLoadGroupListTypeTransport) obj;
		if (fqdn == null) {
			if (other.fqdn != null)
				return false;
		} else if (!fqdn.equals(other.fqdn))
			return false;
		if (loadGroupName == null) {
			if (other.loadGroupName != null)
				return false;
		} else if (!loadGroupName.equals(other.loadGroupName))
			return false;
		if (psxId == null) {
			if (other.psxId != null)
				return false;
		} else if (!psxId.equals(other.psxId))
			return false;
		if (signalingIpAddress == null) {
			if (other.signalingIpAddress != null)
				return false;
		} else if (!signalingIpAddress.equals(other.signalingIpAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PSXLoadGroupListTypeTransport [loadGroupName=" + loadGroupName + ", psxId=" + psxId
				+ ", signalingIpAddress=" + signalingIpAddress + ", fqdn=" + fqdn + "]";
	}
	
	
	public static enum 
	SortField
	{
		LOADGROUPNAME,
		FQDN,
		PSXID,
		SIGNALINGIPADDRESS
		
	}
	public static Comparator< PSXLoadGroupListTypeTransport> getComparator(
			final SortField TYPE,
			final boolean reverse)
	{
		return new Comparator<PSXLoadGroupListTypeTransport>()
		{
			private SortField field = TYPE;
			public int compare(
					PSXLoadGroupListTypeTransport obj1,
					PSXLoadGroupListTypeTransport obj2)
			{
				int result = 0;
				
				switch(field)
				{
					default:
					case LOADGROUPNAME:
						result = compare(obj1.getLoadGroupName(), obj2.getLoadGroupName());
						if (result != 0)
							break;
					case FQDN:
						result = compare(obj1.getFqdn(), obj2.getFqdn());
						if (result != 0)
							break;
					case PSXID:
						result = compare(obj1.getPsxId(), obj2.getPsxId());
						if (result != 0)
							break;
					case SIGNALINGIPADDRESS:
						result = compare(obj1.getSignalingIpAddress(), obj2.getSignalingIpAddress());
						if (result != 0)
							break;
					
				}
				if (reverse)
					result *= -1;
				//logger.debug("Result of compare is : " + result);
				return result;
			}
			private int compare(Comparable t1, Comparable t2) 
			{
				if ((null == t1) && (null == t2)) {
					return 0;
				} else if (null == t1) {
					return -1;
				} else if (null == t2) {
					return 1;
				}
				return t1.compareTo(t2);
			}
		};
	}

	@Override
	public int compareTo(PSXLoadGroupListTypeTransport o) {
		if (null == o)
			return 1;
		if (o == this)
			return 0;
		if (this.equals(o))
			return 0;
		if (null == loadGroupName) {
			if (null != o.getLoadGroupName()) {
			return -1;
			}
		} else {
		int compare = loadGroupName.compareTo(o.getLoadGroupName());
		if (compare != 0)
		return compare;
		}
		return 0;
	}

}

