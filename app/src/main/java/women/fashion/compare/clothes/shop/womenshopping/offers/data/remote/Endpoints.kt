package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote

object Endpoints {

    // BASE URL
    const val BASE_URL = "https://user-reward-system-dev.herokuapp.com"

    // user
    const val DUMMY = "dummy/list"
    const val LOGIN = "/user/API/v1/login"
    const val REGISTER = "/user/API/v1/profile"
    const val GLOBAL_FEED = "/posts/API/v1/timeline"
    const val EMAIL_VERIFICATION_INITIATE = "/user/API/v1/verification/initiate"
    const val EMAIL_VERIFICATION_FINALIZE = "/user/API/v1/verification/finalize"
    const val ALL_USER = "/user/API/v1/profiles"

    // post
    const val CREATE_POST = "/posts/API/v1/create"
    const val UPDATE_POST = "/posts/API/v1/update"
    const val CREATE_COMMENT = "/comments/API/v1/create"
    const val GET_COMMENT_BY_ID = "/comments/API/v1/comments-by-post-id"
    const val UPDATE_COMMENT = "/comments/API/v1/update"

    // timeline
    const val GET_USER_TIMELINE = "/posts/API/v1/timeline"
    const val GET_GLOBAL_TIMELINE = "/posts/API/v1/timeline"

    // wallet
    const val CREDIT_WALLET = "/wallet/API/v1/credit"

    //Like
    const val LIKE_POST = "/likes/API/v1/create/like"
    const val UNLIKE_POST = "/likes/API/v1/create/unlike"
    const val REMOVE_LIKE = "/likes/API/v1/remove-like"
    const val REMOVE_UNLIKE = "/likes/API/v1/remove-unlike"

    // uploads
    const val UPLOAD_MULTIPLE_FILES = "/images/API/v1/upload"

    // rewards
    const val CREATE_REWARD = "/reward/API/v1/create"
    const val ALL_REWARD = "/reward/API/v1/list"
    const val REDEEM_REWARD = "/reward/API/v1/redeem"




}