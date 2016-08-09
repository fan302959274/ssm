package com.tcz.api.model.vo.item;

import java.util.Date;

public class AdVo {

	private Long id;

    private String type;

    private String title;

    private String path;

    private String url;

    private String width;
    
    private String height;
    
    private Long adPositionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getAdPositionId() {
        return adPositionId;
    }

    public void setAdPositionId(Long adPositionId) {
        this.adPositionId = adPositionId;
    }

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
    
}
