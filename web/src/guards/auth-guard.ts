import type { NavigationGuardNext, RouteLocationNormalizedGeneric } from "vue-router";
import * as authService from "../services/auth-service";

export default async function authGuard(
    to: RouteLocationNormalizedGeneric,
    from: RouteLocationNormalizedGeneric,
    next: NavigationGuardNext
) {

    try {
        await authService.getProfile();

        if (to.meta.protectedRoute)
            next();
        if (to.path == "/signin")
            next(from.path);
    } catch (error) {
        if (to.meta.protectedRoute)
            next("/signin");
        else
            next();
    }

    next();
}
