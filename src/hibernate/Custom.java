package hibernate;
// Generated 2017-3-18 21:28:05 by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Custom generated by hbm2java
 */
public class Custom implements java.io.Serializable {

	private int customId;
	private String customName;
	private boolean customSex;
	private String customInfo;
	private int customRank;
	private Float purposePrice;
	private Float purposeArea;
	private String purposePosition;
	private Set performances = new HashSet(0);
	private Set followups = new HashSet(0);

	public Custom() {
	}

	public Custom(int customId, String customName, boolean customSex, int customRank) {
		this.customId = customId;
		this.customName = customName;
		this.customSex = customSex;
		this.customRank = customRank;
	}

	public Custom(int customId, String customName, boolean customSex, String customInfo, int customRank,
			Float purposePrice, Float purposeArea, String purposePosition, Set performances, Set followups) {
		this.customId = customId;
		this.customName = customName;
		this.customSex = customSex;
		this.customInfo = customInfo;
		this.customRank = customRank;
		this.purposePrice = purposePrice;
		this.purposeArea = purposeArea;
		this.purposePosition = purposePosition;
		this.performances = performances;
		this.followups = followups;
	}

	public int getCustomId() {
		return this.customId;
	}

	public void setCustomId(int customId) {
		this.customId = customId;
	}

	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public boolean isCustomSex() {
		return this.customSex;
	}

	public void setCustomSex(boolean customSex) {
		this.customSex = customSex;
	}

	public String getCustomInfo() {
		return this.customInfo;
	}

	public void setCustomInfo(String customInfo) {
		this.customInfo = customInfo;
	}

	public int getCustomRank() {
		return this.customRank;
	}

	public void setCustomRank(int customRank) {
		this.customRank = customRank;
	}

	public Float getPurposePrice() {
		return this.purposePrice;
	}

	public void setPurposePrice(Float purposePrice) {
		this.purposePrice = purposePrice;
	}

	public Float getPurposeArea() {
		return this.purposeArea;
	}

	public void setPurposeArea(Float purposeArea) {
		this.purposeArea = purposeArea;
	}

	public String getPurposePosition() {
		return this.purposePosition;
	}

	public void setPurposePosition(String purposePosition) {
		this.purposePosition = purposePosition;
	}

	public Set getPerformances() {
		return this.performances;
	}

	public void setPerformances(Set performances) {
		this.performances = performances;
	}

	public Set getFollowups() {
		return this.followups;
	}

	public void setFollowups(Set followups) {
		this.followups = followups;
	}

}
