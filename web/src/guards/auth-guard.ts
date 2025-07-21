import type { NavigationGuardNext, RouteLocationNormalizedGeneric } from "vue-router";
import * as authService from "../services/auth-service";

export default async function authGuard(
  to: RouteLocationNormalizedGeneric,
  from: RouteLocationNormalizedGeneric,
  next: NavigationGuardNext
) {

    if (to.meta.protectedRoute) {
        try {
            const me = await authService.getProfile()
            console.log(me.data);
            next();
        } catch (error) {
            next("/signin");
        }
    } else {
        next();
    }
}
