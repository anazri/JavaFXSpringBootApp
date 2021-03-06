/**
 * 
 */
package app.tiktok.follow;

import app.tiktok.request.BaseResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuanhiep225
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApproveFollowResponse extends BaseResponseData {
	/** 0 if the user was successfully approved */
	Integer approve_status;
}
